package com.konarskirob.data.topics

class InfoTopic : RxTopic<InfoMessage>()

sealed class InfoMessage
class Action(val data: String) : InfoMessage()
class Close : InfoMessage()