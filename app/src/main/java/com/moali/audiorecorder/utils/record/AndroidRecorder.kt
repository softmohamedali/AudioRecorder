package com.moali.audiorecorder.utils.record

import java.io.File

interface AndroidRecorder {
    fun startRecord(outPutFile:File)
    fun stopRecord()
}