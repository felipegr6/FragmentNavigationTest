package br.fgr.fragmentnavigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.fragment_screen_one.*

class Screen01Fragment : BaseFragment() {
    override fun getIdentifier(): String? = TAG

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_email.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    nextScreen()
                    false
                }
                else -> false
            }
        }


        bt_next.setOnClickListener {
            it.requestFocus()
            nextScreen()
        }
    }

    private fun nextScreen() {
        // activity?.nextScreen(
        //     Action.REPLACE,
        //     Screen02Fragment.newInstance(
        //         et_name.text.toString(),
        //         et_postal_code.text.toString(),
        //         et_email.text.toString()
        //     ),
        //     Screen02Fragment.TAG,
        //     addToBackStack = true
        // )
        activity?.nextScreen(
            Action.ADD,
            Screen02Fragment.newInstance(
                et_name.text.toString(),
                et_postal_code.text.toString(),
                et_email.text.toString()
            ),
            Screen02Fragment.TAG,
            addToBackStack = true
        )
    }

    companion object {
        const val TAG = "Screen01Fragment"
    }
}
