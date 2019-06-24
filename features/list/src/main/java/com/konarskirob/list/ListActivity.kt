package com.konarskirob.list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.konarskirob.core.extensions.listen
import com.konarskirob.data.topics.Action
import com.konarskirob.data.topics.Close
import com.konarskirob.data.topics.InfoTopic
import com.konarskirob.list.di.listComponent
import com.konarskirob.navigation.Nav
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject


class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var router: ListRouter

    @Inject
    lateinit var infoTopic: InfoTopic

    private val infoFragment: Fragment? by lazy {
        val cache = supportFragmentManager.findFragmentByTag("tag")
        cache ?: router.provideInfoFragment()
    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listComponent().inject(this)

        list.setOnClickListener {
            router.routeToDetail(this, "fake_id")
        }

        infoButton.setOnClickListener {
            infoFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.infoFrame, it, "tag")
                    .commit()
            }
        }

        infoTopic.data.listen(this) { message ->
            when (message) {
                is Action -> onAction(message.data)
                is Close -> onClose()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DetailRequestCode) {
            Nav.Detail.result(resultCode, data)?.let { result ->
                Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun onClose() {
        infoFragment?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
        }
    }

    private fun onAction(data: String) {
        Toast.makeText(this, "onAction: $data", Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val DetailRequestCode = 1
    }
}