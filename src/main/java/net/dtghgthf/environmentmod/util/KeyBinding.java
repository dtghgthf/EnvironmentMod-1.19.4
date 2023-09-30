package net.dtghgthf.environmentmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_ENVIRONMENT_MOD = "key.category.environmentmod.environment";
    public static final String KEY_INCREASE_POLLUTION = "key.tutorialmod.increase_pollution";
    public static final String KEY_DECREASE_POLLUTION = "key.tutorialmod.decrease_pollution";

    public static final KeyMapping INCREASING_POLLUTION_KEY = new KeyMapping(KEY_INCREASE_POLLUTION, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_ENVIRONMENT_MOD);

    public static final KeyMapping DECREASING_POLLUTION_KEY = new KeyMapping(KEY_DECREASE_POLLUTION, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_L, KEY_CATEGORY_ENVIRONMENT_MOD);


}
