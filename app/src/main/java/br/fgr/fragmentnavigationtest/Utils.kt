package br.fgr.fragmentnavigationtest

import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

fun FragmentActivity.nextScreen(action: Transaction, fragment: Fragment, tag: String, addToBackStack: Boolean = false) {
    action.onTransacting(supportFragmentManager, fragment, tag, addToBackStack)
}

enum class Action : Transaction {
    ADD {
        override fun onTransacting(
            manager: FragmentManager,
            fragment: Fragment,
            tag: String,
            addToBackStack: Boolean
        ) {
            val transaction = manager.beginTransaction()
            transaction.add(R.id.container, fragment, tag)
            /**
             * Se for a primeira tela, ao voltar, ele exibirá uma tela em branco, independente se for passado null ou não no tag.
             */
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commit()
        }
    },
    REPLACE {
        override fun onTransacting(
            manager: FragmentManager,
            fragment: Fragment,
            tag: String,
            addToBackStack: Boolean
        ) {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.container, fragment, tag)
            /**
             * Se for a primeira tela, ao voltar, ele exibirá uma tela em branco, independente se for passado null ou não no tag.
             */
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commit()
        }
    },
    SHOW {
        override fun onTransacting(
            manager: FragmentManager,
            fragment: Fragment,
            tag: String,
            addToBackStack: Boolean
        ) {
            (fragment as DialogFragment).show(manager, tag)
        }
    }
}

interface Transaction {
    fun onTransacting(manager: FragmentManager, fragment: Fragment, tag: String, addToBackStack: Boolean)
}

interface YesOrNoButtonAction {
    fun onYesAction()
    fun onNoAction()
}
