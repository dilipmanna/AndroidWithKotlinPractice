package com.example.kotlinexample.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlinexample.R

class BlueFragment : Fragment() {

    companion object{
       val  TAG:String = BlueFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG,"OnCreateView")
        return inflater.inflate(R.layout.blue_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        Log.i(TAG,"OnAttach")
        super.onAttach(context)
    }

    override fun onAttachFragment(childFragment: Fragment) {
        Log.i(TAG,"OnAttachFragment")
        super.onAttachFragment(childFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG,"onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG,"onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.i(TAG,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG,"onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG,"onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i(TAG,"onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i(TAG,"onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i(TAG,"onDetach")
        super.onDetach()
    }

}
