package com.konarskirob.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.konarskirob.core.NavigationFragment
import com.konarskirob.navigation.InfoCallback
import com.konarskirob.navigation.InfoInput
import com.konarskirob.navigation.Navigation
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), InfoCallback {

    private val infoFragment: NavigationFragment<InfoInput, InfoCallback>? by lazy {
        val cache = supportFragmentManager.findFragmentByTag("tag") as? NavigationFragment<InfoInput, InfoCallback>
        cache ?: Navigation.Info.fragment()
    }

    override fun onClose() {
        infoFragment?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
        }
    }

    override fun onAction() {
        Toast.makeText(this, "onAction", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        infoFragment?.apply {
            input = InfoInput("MyFavId")
            callback = this@ListActivity
        }

        list.setOnClickListener {
            startActivityForResult(Navigation.Detail.activity(this, "fake_id"), DetailRequestCode)
        }

        infoButton.setOnClickListener {
            infoFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.infoFrame, it, "tag")
                    .commit()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DetailRequestCode) {
            Navigation.Detail.result(resultCode, data)?.let { result ->
                Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        infoFragment?.clear()
    }

    companion object {

        private const val DetailRequestCode = 1

        fun newIntent(context: Context) = Intent(context, ListActivity::class.java)
    }
}