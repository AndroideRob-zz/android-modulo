package com.konarskirob.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.konarskirob.data.topics.Action
import com.konarskirob.data.topics.Close
import com.konarskirob.data.topics.InfoTopic
import com.konarskirob.di.baseComponent
import com.konarskirob.info.di.DaggerInfoComponent
import kotlinx.android.synthetic.main.fragment_info.*
import javax.inject.Inject


class InfoFragment : Fragment() {

    @Inject
    lateinit var topic: InfoTopic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerInfoComponent.builder().baseComponent(baseComponent()).build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        action.setOnClickListener {
            topic.post(Action("Liol"))
        }

        close.setOnClickListener {
            topic.post(Close())
        }
    }
}