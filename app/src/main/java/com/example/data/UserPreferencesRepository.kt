package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.truthPopDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "truthpop_prefs"
)

/**
 * Persists lightweight UI preferences (language, haptics, favorites) on-device.
 * No account, no network — pure local DataStore.
 */
class UserPreferencesRepository(private val context: Context) {

    private object Keys {
        val LANGUAGE = stringPreferencesKey("language")
        val HAPTICS = booleanPreferencesKey("haptics")
        val FAVORITES = stringSetPreferencesKey("favorites")
    }

    data class Prefs(
        val languageCode: String?,
        val haptics: Boolean?,
        val favorites: Set<String>?
    )

    val prefs: Flow<Prefs> = context.truthPopDataStore.data.map { p ->
        Prefs(
            languageCode = p[Keys.LANGUAGE],
            haptics = p[Keys.HAPTICS],
            favorites = p[Keys.FAVORITES]
        )
    }

    suspend fun setLanguage(code: String) {
        context.truthPopDataStore.edit { it[Keys.LANGUAGE] = code }
    }

    suspend fun setHaptics(enabled: Boolean) {
        context.truthPopDataStore.edit { it[Keys.HAPTICS] = enabled }
    }

    suspend fun setFavorites(ids: Set<String>) {
        context.truthPopDataStore.edit { it[Keys.FAVORITES] = ids }
    }
}
