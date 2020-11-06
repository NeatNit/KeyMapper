package io.github.sds100.keymapper

import androidx.multidex.MultiDexApplication
import io.github.sds100.keymapper.data.IOnboardingState
import io.github.sds100.keymapper.data.repository.DefaultKeymapRepository
import io.github.sds100.keymapper.data.repository.DeviceInfoRepository
import timber.log.Timber

/**
 * Created by sds100 on 19/05/2020.
 */
class MyApplication : MultiDexApplication() {

    val keymapRepository: DefaultKeymapRepository
        get() = ServiceLocator.provideKeymapRepository(this)

    val deviceInfoRepository: DeviceInfoRepository
        get() = ServiceLocator.provideDeviceInfoRepository(this)

    val onboardingState: IOnboardingState
        get() = ServiceLocator.provideOnboardingState(this)

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}