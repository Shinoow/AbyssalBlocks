package com.shinoow.acblocks.client.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigElement;

import com.shinoow.acblocks.AbyssalBlocks;

import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;
import cpw.mods.fml.client.config.IConfigElement;

public class ACBConfigGUI extends GuiConfig {

	public ACBConfigGUI(GuiScreen parent) {
		super(parent, getConfigElements(), "acblocks", true, true, "AbyssalBlocks");
	}

	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements(){
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyCategoryElement<Object>(StatCollector.translateToLocal("acb_general"), "acb_general", GeneralEntry.class));
		return list;
	}

	public static class GeneralEntry extends CategoryEntry{

		public GeneralEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
			super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen(){
			return new GuiConfig(owningScreen, new ConfigElement<Object>(AbyssalBlocks.cfg.getCategory("general")).getChildElements(), "acblocks", "general", true, true, StatCollector.translateToLocal("acb_general"));

		}
	}
}