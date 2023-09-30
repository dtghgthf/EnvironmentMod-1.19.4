package net.dtghgthf.environmentmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dtghgthf.environmentmod.EnvironmentMod;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.logging.Logger;

public class PollutionHudOverlay {

    private static final ResourceLocation POLLUTION_FRAME = new ResourceLocation(EnvironmentMod.MOD_ID,
            "textures/pollution/pollution_frame.png");

    private static final ResourceLocation POLLUTION_FILL = new ResourceLocation(EnvironmentMod.MOD_ID,
            "textures/pollution/pollution_fill.png");

    private static final ResourceLocation POLLUTION_STAGE_INDICATOR = new ResourceLocation(EnvironmentMod.MOD_ID,
            "textures/pollution/pollution_stage_indicator.png");

    public static final IGuiOverlay HUD_POLLUTION = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, POLLUTION_FRAME);

        GuiComponent.blit(poseStack, 11, 11, 0, 0, 32, 64,
                32, 64);

        RenderSystem.setShaderTexture(0, POLLUTION_FILL);

        for (int i = 0; i < 60; i++) {
            if (EnvironmentMod.pollutionValue >= i) {
                GuiComponent.blit(poseStack, 11 + 2, 11 + 61 - i, 0, 0, 28, 1,
                        28, 1);
            } else {
                break;
            }
        }

        RenderSystem.setShaderTexture(0, POLLUTION_STAGE_INDICATOR);

        for (int i = 0; i < 8; i++) {
            if (getStageNumber() >= i) {
                GuiComponent.blit(poseStack, 11 + 35, 11 + 56 - (i * 8), 0, 0, 5, 8,
                        5, 8);
            } else {
                break;
            }
        }

    });

    public static int getStageNumber() {
        int value = EnvironmentMod.pollutionValue;

        int returnValue = 0;

        for (int i = 0; i <= 8; i++) {
            if (i * 60 <= value) {
                returnValue = i;
            }
        }

        EnvironmentMod.pollutionStage = returnValue;
        return returnValue;
    }
}
