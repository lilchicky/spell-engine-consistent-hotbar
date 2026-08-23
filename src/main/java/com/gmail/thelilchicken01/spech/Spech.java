package com.gmail.thelilchicken01.spech;

import com.gmail.thelilchicken01.spech.util.SpECHTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.spell_engine.api.spell.SpellDataComponents;
import net.spell_engine.api.spell.container.SpellContainer;
import net.spell_engine.api.spell.container.SpellContainerHelper;
import net.spell_engine.api.spell.container.SpellContainers;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;

import java.util.List;

@Mod(Spech.MODID)
public class Spech {
    public static final String MODID = "spech";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Spech(IEventBus modEventBus, ModContainer modContainer) {
    }
}
