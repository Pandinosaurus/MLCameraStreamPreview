package com.iebayirli.mlcamerastreampreview

import android.util.SparseArray
import androidx.lifecycle.MutableLiveData
import com.huawei.hms.mlsdk.common.MLAnalyzer
import kotlinx.android.synthetic.main.activity_main.*


class Transactor<T>(private val transactResult: ((MLAnalyzer.Result<T>?) -> Unit)? = null,
                    private val destroy: (() -> Unit)? = null) : MLAnalyzer.MLTransactor<T>{


    private var resultList = MutableLiveData<MLAnalyzer.Result<T>?>()

    fun <T>getResult() = resultList as MutableLiveData<MLAnalyzer.Result<T>?>

    override fun transactResult(p0: MLAnalyzer.Result<T>?) {
        transactResult?.invoke(p0)
        resultList.postValue(p0)
    }

    override fun destroy() {
        destroy?.invoke()
    }

}