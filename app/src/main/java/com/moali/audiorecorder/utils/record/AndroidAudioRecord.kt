package com.moali.audiorecorder.utils.record

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File
import java.io.FileOutputStream

class AndroidAudioRecord(
    private val context: Context
):AndroidRecorder {

    private  var recorder:MediaRecorder?=null

    private fun createRecorder():MediaRecorder{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        }else MediaRecorder()
    }
    override fun startRecord(outPutFile: File) {
        createRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(FileOutputStream(outPutFile).fd)

            prepare()
            start()
            recorder=this
        }

    }

    override fun stopRecord() {
        recorder?.stop()
        recorder?.reset()
        recorder=null
    }
}