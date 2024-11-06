import daisyPlugin from "daisyui";
import typography from "@tailwindcss/typography";

export const content = ["./src/**/*.cljs"];
export const theme = {
	extend: {},
};
export const plugins = [typography, daisyPlugin];

export const daisyui = {
	themes: ['light', 'dark']
}
