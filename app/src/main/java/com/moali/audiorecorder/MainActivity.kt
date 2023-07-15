package com.moali.audiorecorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.moali.audiorecorder.ui.theme.AudioRecorderTheme
import com.moali.audiorecorder.utils.audioPlayer.AndroidAudioPlayer
import com.moali.audiorecorder.utils.record.AndroidAudioRecord
import java.io.File
import java.util.jar.Manifest

class MainActivity : ComponentActivity() {

    private val audioRecord by lazy { AndroidAudioRecord(this) }
    private val audioPlayer by lazy { AndroidAudioPlayer(this) }
    private var audio: File?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.RECORD_AUDIO),
        0
        )
        setContent {
            AudioRecorderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround
                    ){
                        Button(
                            onClick = {
                                File(cacheDir,"audio.mp3").also {
                                    audioRecord.startRecord(it)
                                    audio=it
                                }
                            }) {
                            Text(text = "start REcord")
                        }
                        Button(
                            onClick = { audioRecord.stopRecord() }) {
                            Text(text = "stop REcord")
                        }
                        Button(
                            onClick = { audioPlayer.playAudio(audio!!)}) {
                            Text(text = "start play")
                        }
                        Button(
                            onClick = { audioPlayer.stopAudio() }) {
                            Text(text = "stop play")
                        }
                    }
                }
            }
        }
    }
}

