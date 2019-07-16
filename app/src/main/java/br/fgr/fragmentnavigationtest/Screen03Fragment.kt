package br.fgr.fragmentnavigationtest

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_screen_three.*

class Screen03Fragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_three, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_no.setOnClickListener {
            (targetFragment as YesOrNoButtonAction).onNoAction()
            dismiss()
        }

        btn_yes.setOnClickListener {
            (targetFragment as YesOrNoButtonAction).onYesAction()
            dismiss()
        }
    }

    companion object {
        const val TAG = "Screen03Fragment"
    }
}
