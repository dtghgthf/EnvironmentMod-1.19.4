package net.dtghgthf.environmentmod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.dtghgthf.environmentmod.EnvironmentMod;
import net.dtghgthf.environmentmod.networking.ModMesssages;
import net.dtghgthf.environmentmod.networking.packet.ExampleC2SPacket;
import net.dtghgthf.environmentmod.screen.EnvironmentInfoScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class EnvironmentCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("environment")
                    .executes((command) -> 0
                )
                .then(Commands.literal("reset")
                        .executes((command) -> {
                            ModMesssages.sendToServer(new ExampleC2SPacket());
                            return 1;
                        })
                )
                .then(Commands.literal("info")
                        .executes((command) -> 0)
                        .then(Commands.literal("chat")
                                .executes((command) -> {
                                    return 0;
                                })
                        )
                        .then(Commands.literal("gui")
                                .executes((command) -> {
                                    return 0;
                                })
                        )
                )
        );
    }
}