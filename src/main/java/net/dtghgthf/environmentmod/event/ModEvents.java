package net.dtghgthf.environmentmod.event;

import net.dtghgthf.environmentmod.EnvironmentMod;
import net.dtghgthf.environmentmod.networking.ModMesssages;
import net.dtghgthf.environmentmod.networking.packet.ExampleC2SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = EnvironmentMod.MOD_ID)
    public class ForgeEvents {
        @SubscribeEvent
        public static void onBlockBreakEvent(BlockEvent.BreakEvent event) {
            LevelAccessor level = event.getLevel();
            BlockPos blockPos = event.getPos();
            BlockState blockState = level.getBlockState(blockPos);
            Block block = blockState.getBlock();

            if (isTreeBlock(blockPos, level)) {
                EnvironmentMod.pollutionValue++;
                ModMesssages.sendToServer(new ExampleC2SPacket());
            }
        }

        @SubscribeEvent
        public static void onFriendlyEntityKilled(LivingDeathEvent event) {
            Entity victimEntity = event.getEntity();
            DamageSource source = event.getSource();

            System.out.println(source.getEntity());

            if (victimEntity instanceof Animal && (source.getEntity() instanceof ServerPlayer || source.getEntity() instanceof LocalPlayer)) {
                EnvironmentMod.pollutionValue++;
            }
        }
    }

    private static boolean isTreeBlock(BlockPos blockPos, LevelAccessor level) {
        Block below = level.getBlockState(blockPos.below(1)).getBlock();
        Block above = level.getBlockState(blockPos.above(1)).getBlock();

        if ((isLogOrStrippedLog(above) || isLogOrStrippedLog(below)) || (isLogOrStrippedLog(above) && isLogOrStrippedLog(below))) {
            return true;
        }

        return false;
    }

    private static boolean isLogOrStrippedLog(Block block) {
        MutableComponent registryName = block.getName();

        String blockName = registryName.toString().toLowerCase();

        // Check if the block is a log or a stripped log
        return blockName.contains("log") || blockName.contains("stripped_log");

    }
}
