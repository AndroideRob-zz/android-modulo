package com.konarskirob.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.konarskirob.core.NavigationFragment
import com.konarskirob.core.extensions.isLazyInitialized
import com.konarskirob.navigation.Nav
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity(), Nav.Info.Callback {

    private val infoFragment: NavigationFragment<Nav.Info.Input, Nav.Info.Callback>? by lazy {
        val cache = supportFragmentManager.findFragmentByTag("tag") as? NavigationFragment<Nav.Info.Input, Nav.Info.Callback>
        cache ?: Nav.Info.fragment()
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
            input = Nav.Info.Input("MyFavId")
            callback = this@ListActivity
        }

        Nav.Info.fragment()

        list.setOnClickListener {
            startActivityForResult(Nav.Detail.intent(this, "fake_id"), DetailRequestCode)
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
            Nav.Detail.result(resultCode, data)?.let { result ->
                Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (::infoFragment.isLazyInitialized) {
            infoFragment?.clear()
        }
    }

    companion object {

        private const val DetailRequestCode = 1

        fun newIntent(context: Context) = Intent(context, ListActivity::class.java)
    }
}