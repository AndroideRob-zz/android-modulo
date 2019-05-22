package com.konarskirob.navigation


internal object Internal {

    private val cache = mutableMapOf<String, Class<*>>()

    fun <T> loadClass(className: String): Class<T>? {
        return cache.getOrPut(className) {
            try {
                Class.forName(className)
            } catch (e: ClassNotFoundException) {
                return null
            }
        } as? Class<T>
    }
}