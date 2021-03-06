package cn.banny.emulator.hook.hookzz;

import cn.banny.emulator.Emulator;
import cn.banny.emulator.pointer.UnicornPointer;
import com.sun.jna.Pointer;
import unicorn.Arm64Const;

public class Arm64HookEntryInfo implements HookEntryInfo {

    private final Pointer info;

    Arm64HookEntryInfo(Emulator emulator) {
        info = UnicornPointer.register(emulator, Arm64Const.UC_ARM64_REG_X1);
    }

    @Override
    public long getHookId() {
        return info.getLong(0);
    }

    @Override
    public long getAddress() {
        return info.getLong(8);
    }
}
