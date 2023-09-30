package net.dtghgthf.environmentmod.item.custom;

import net.dtghgthf.environmentmod.screen.EnvironmentInfoScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EnvironmentInfoItem extends Item {
    public EnvironmentInfoItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            Minecraft.getInstance().setScreen(new EnvironmentInfoScreen());
        }

        return super.use(level, player, hand);
    }
}
