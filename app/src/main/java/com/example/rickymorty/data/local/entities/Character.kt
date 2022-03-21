package com.example.rickymorty.data.local.entities

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val gender: String,
    val status: String,
    val species: String,
    val origin: String
)
/*
2022-03-21 20:52:06.991 8555-8555/com.example.rickymorty E/AndroidRuntime: FATAL EXCEPTION: main
Process: com.example.rickymorty, PID: 8555
java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
at com.google.gson.stream.JsonReader.beginArray(JsonReader.java:350)
at com.google.gson.internal.bind.CollectionTypeAdapterFactory$Adapter.read(CollectionTypeAdapterFactory.java:80)
at com.google.gson.internal.bind.CollectionTypeAdapterFactory$Adapter.read(CollectionTypeAdapterFactory.java:61)
at retrofit2.converter.gson.GsonResponseBodyConverter.convert(GsonResponseBodyConverter.java:40)
at retrofit2.converter.gson.GsonResponseBodyConverter.convert(GsonResponseBodyConverter.java:27)
at retrofit2.OkHttpCall.parseResponse(OkHttpCall.java:243)
at retrofit2.OkHttpCall$1.onResponse(OkHttpCall.java:153)
at okhttp3.internal.connection.RealCall$AsyncCall.run(RealCall.kt:519)
at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
at java.lang.Thread.run(Thread.java:919)

 */

