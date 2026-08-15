package com.gmail.thelilchicken01.spech;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;

@Mod(Spech.MODID)
public class Spech {
    public static final String MODID = "spech";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Spech(IEventBus modEventBus, ModContainer modContainer) {
    }
}
