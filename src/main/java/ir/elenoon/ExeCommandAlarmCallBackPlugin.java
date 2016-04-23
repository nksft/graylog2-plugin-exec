package ir.elenoon;

import org.graylog2.plugin.Plugin;
import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.PluginModule;

import java.util.Arrays;
import java.util.Collection;

/**
 * Implement the Plugin interface here.
 */
public class ExeCommandAlarmCallBackPlugin implements Plugin {
    @Override
    public PluginMetaData metadata() {
        return new ExeCommandAlarmCallBackMetaData();
    }

    @Override
    public Collection<PluginModule> modules () {
        return Arrays.<PluginModule>asList(new ExeCommandAlarmCallBackModule());
    }
}
