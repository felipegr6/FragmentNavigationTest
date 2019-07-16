package br.fgr.fragmentnavigationtest

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_screen_two.*

class Screen02Fragment : BaseFragment(), YesOrNoButtonAction {
    private var dialog: DialogFragment? = null
    override fun onNoAction() {
        dialog?.dismiss()
        Log.i(getIdentifier(), "No button")
    }

    override fun onYesAction() {
        dialog?.dismiss()
        Log.i(getIdentifier(), "YesButton")
        router?.endFlow(Screen04Fragment())
    }

    override fun getIdentifier(): String? = TAG

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_name.text = arguments?.getString(NAME)
        tv_postal.text = arguments?.getString(POSTAL_CODE)
        tv_email.text = arguments?.getString(EMAIL)

        bt_finalize.setOnClickListener {
            Log.i(TAG, "finalize button")
            dialog = Screen03Fragment()
            (dialog as Screen03Fragment).setTargetFragment(this, 1)
            activity?.nextScreen(Action.SHOW, dialog as Screen03Fragment, Screen03Fragment.TAG, addToBackStack = true)
        }
    }

    companion object {
        const val TAG = "Screen02Fragment"
        private const val NAME = "NAME"
        private const val POSTAL_CODE = "POSTAL_CODE"
        private const val EMAIL = "EMAIL"

        fun newInstance(name: String?, postalCode: String?, email: String?): Screen02Fragment {
            val fragment = Screen02Fragment()
            val args = Bundle()
            args.putString(NAME, name)
            args.putString(POSTAL_CODE, postalCode)
            args.putString(EMAIL, email)
            fragment.arguments = args

            return fragment
        }
    }
}
