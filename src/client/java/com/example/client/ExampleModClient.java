package com.example.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ExampleModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;

            int fps = client.getCurrentFps();

            boolean w = client.options.forwardKey.isPressed();
            boolean a = client.options.leftKey.isPressed();
            boolean s = client.options.backKey.isPressed();
            boolean d = client.options.rightKey.isPressed();

            String fpsText = "§aFPS: §f" + fps;
            String wasd = (w ? "§a[W]" : "§7[W]") + " " +
                          (a ? "§a[A]" : "§7[A]") + " " +
                          (s ? "§a[S]" : "§7[S]") + " " +
                          (d ? "§a[D]" : "§7[D]");
            String clientName = "§6Chernw §fClient";

            context.drawTextWithShadow(client.textRenderer, clientName, 5, 5, 0xFFFFFF);
            context.drawTextWithShadow(client.textRenderer, fpsText, 5, 15, 0xFFFFFF);
            context.drawTextWithShadow(client.textRenderer, wasd, 5, 25, 0xFFFFFF);
        });
    }
}
