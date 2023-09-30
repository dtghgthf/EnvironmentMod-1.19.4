package net.dtghgthf.environmentmod.networking.packet;

import net.dtghgthf.environmentmod.EnvironmentMod;
import net.dtghgthf.environmentmod.client.PollutionHudOverlay;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ExampleC2SPacket {
    public ExampleC2SPacket() {

    }

    public ExampleC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {
            // ON SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            //EntityType.COW.spawn(level, null, null, player.blockPosition(),
            //        MobSpawnType.COMMAND, true, false);

            player.sendSystemMessage(Component.literal("Value: " + EnvironmentMod.pollutionValue + "; Stage: " + EnvironmentMod.pollutionStage));
        });
        return true;
    }

}
