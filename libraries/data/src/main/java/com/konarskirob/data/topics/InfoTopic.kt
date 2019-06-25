package com.konarskirob.data.topics

class InfoTopic : RxPublishTopic<InfoMessage>()

sealed class InfoMessage
class Action(val data: String) : InfoMessage()
class Close : InfoMessage()