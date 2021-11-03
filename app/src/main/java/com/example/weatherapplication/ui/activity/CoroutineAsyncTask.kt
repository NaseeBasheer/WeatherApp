package com.example.weatherapplication.ui.activity

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class CoroutineAsyncTask<Params, Progress, Result> {
    open fun onPreExecute(){}
    abstract fun doInBackground(vararg params: String?): String?
   open fun onPostExecute(result: String?){}

    fun execute(vararg params: String?){
        CoroutineScope(Dispatchers.Default).launch {
            val result = doInBackground(*params)
            withContext(Dispatchers.Main){
                onPostExecute(result)
            }
        }
    }
}