package com.moali.audiorecorder.utils.audioPlayer

import java.io.File

interface AndroidPlayer {
    fun playAudio(audioFile:File)
    fun stopAudio()
}