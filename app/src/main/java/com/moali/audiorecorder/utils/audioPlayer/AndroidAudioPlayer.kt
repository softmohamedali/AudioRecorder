package com.moali.audiorecorder.utils.audioPlayer

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import java.io.File

class AndroidAudioPlayer(
    private val context: Context
):AndroidPlayer {

    private var player:MediaPlayer?=null



    override fun playAudio(audioFile: File) {
        MediaPlayer.create(context,audioFile.toUri()).apply {
            player=this
            start()
        }
    }

    override fun stopAudio() {
        player?.stop()
        player?.release()
        player=null
    }
}