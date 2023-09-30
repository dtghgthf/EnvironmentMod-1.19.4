package net.dtghgthf.environmentmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnvironmentInfoScreen extends Screen {

    private static final ResourceLocation WINDOW_LOCATION = new ResourceLocation("textures/gui/advancements/window.png");

    @Override
    protected void init() {
        this.addRenderableWidget(new Button(this.width / 2 - 100, this.height - 40, 200, 20, Component.literal("test"), (p_96074_) -> {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Test!"));
            Minecraft.getInstance().popGuiLayer();
        }));
    }

    @Override
    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {

        int x = (this.width - 252) / 2;
        int y = (this.height - 140) / 2;

        this.renderBackground(p_96562_);

        super.render(p_96562_, p_96563_, p_96564_, p_96565_);
    }

    public EnvironmentInfoScreen() {
        super(Component.empty());
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
