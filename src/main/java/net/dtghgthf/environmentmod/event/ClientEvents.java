package net.dtghgthf.environmentmod.event;

import net.dtghgthf.environmentmod.EnvironmentMod;
import net.dtghgthf.environmentmod.client.PollutionHudOverlay;
import net.dtghgthf.environmentmod.command.EnvironmentCommand;
import net.dtghgthf.environmentmod.networking.ModMesssages;
import net.dtghgthf.environmentmod.networking.packet.ExampleC2SPacket;
import net.dtghgthf.environmentmod.screen.EnvironmentInfoScreen;
import net.dtghgthf.environmentmod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = EnvironmentMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.INCREASING_POLLUTION_KEY.consumeClick()) {
                EnvironmentMod.pollutionValue++;
                ModMesssages.sendToServer(new ExampleC2SPacket());
            }

            if (KeyBinding.DECREASING_POLLUTION_KEY.consumeClick()) {
                EnvironmentMod.pollutionValue--;
                ModMesssages.sendToServer(new ExampleC2SPacket());
            }
        }

        @SubscribeEvent
        public static void onCommandsRegister(RegisterCommandsEvent event) {
            EnvironmentCommand.register(event.getDispatcher());

            ConfigCommand.register(event.getDispatcher());
        }
    }

    @Mod.EventBusSubscriber(modid = EnvironmentMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.INCREASING_POLLUTION_KEY);
            event.register(KeyBinding.DECREASING_POLLUTION_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("pollution", PollutionHudOverlay.HUD_POLLUTION);
        }


    }

}
