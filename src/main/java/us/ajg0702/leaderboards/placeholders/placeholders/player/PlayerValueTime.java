package us.ajg0702.leaderboards.placeholders.placeholders.player;

import org.bukkit.OfflinePlayer;
import us.ajg0702.leaderboards.LeaderboardPlugin;
import us.ajg0702.leaderboards.boards.TimedType;
import us.ajg0702.leaderboards.placeholders.Placeholder;

import java.util.Locale;
import java.util.regex.Matcher;

@Deprecated
public class PlayerValueTime extends Placeholder {
    public PlayerValueTime(LeaderboardPlugin plugin) {
        super(plugin);
    }

    @Override
    public String getRegex() {
        return "value_(.*)_(.*)_time";
    }

    @Override
    public String parse(Matcher matcher, OfflinePlayer p) {
        plugin.timePlaceholderUsed();
        String board = matcher.group(1);
        String typeRaw = matcher.group(2).toUpperCase(Locale.ROOT);
        return plugin.getTopManager().getStatEntry(p, board, TimedType.valueOf(typeRaw)).getTime();
    }
}
