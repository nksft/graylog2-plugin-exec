package ir.elenoon;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * Implement the PluginMetaData interface here.
 */
public class ExeCommandAlarmCallBackMetaData implements PluginMetaData {
    @Override
    public String getUniqueId() {
        return "ir.elenoon.ExeCommandAlarmCallBackPlugin";
    }

    @Override
    public String getName() {
        return "ExeCommandAlarmCallBack";
    }

    @Override
    public String getAuthor() {
        return "ahmad.niksefat@gmail.com";
    }

    @Override
    public URI getURL() {
        return URI.create("https://www.elenoon.ir/");
    }

    @Override
    public Version getVersion() {
        return new Version(1, 0, 0);
    }

    @Override
    public String getDescription() {
        return "A graylog2 alarm callback for executing commands on server.";
    }

    @Override
    public Version getRequiredVersion() {
        return new Version(1, 0, 0);
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
