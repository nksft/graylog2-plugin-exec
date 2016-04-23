package ir.elenoon;

import java.io.IOException;
import java.util.Map;

import org.graylog2.plugin.alarms.AlertCondition.CheckResult;
import org.graylog2.plugin.alarms.callbacks.AlarmCallback;
import org.graylog2.plugin.alarms.callbacks.AlarmCallbackConfigurationException;
import org.graylog2.plugin.alarms.callbacks.AlarmCallbackException;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationException;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.configuration.fields.ConfigurationField;
import org.graylog2.plugin.configuration.fields.TextField;
import org.graylog2.plugin.streams.Stream;

/**
 * This is the plugin. Your class should implement one of the existing plugin
 * interfaces. (i.e. AlarmCallback, MessageInput, MessageOutput)
 */
public class ExeCommandAlarmCallBack implements AlarmCallback{
	private Configuration configs;

	@Override
	public void call(Stream arg0, CheckResult arg1)
			throws AlarmCallbackException {
		try {
			Runtime.getRuntime().exec(new String[]{"bash","-c",configs.getString("bashCommand")});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void checkConfiguration() throws ConfigurationException {
		String command = configs.getString("bashCommand");
		if (command.isEmpty())
			throw new ConfigurationException("Fill the bash command field.");
			 
	}

	@Override
	public Map<String, Object> getAttributes() {
		return configs.getSource();
	}

	@Override
	public String getName() {
		return "Execute Command Alarm Callback";
	}

	@Override
	public ConfigurationRequest getRequestedConfiguration() {
		final ConfigurationRequest configurationRequest = new ConfigurationRequest();
		configurationRequest.addField(new TextField("bashCommand", "Bash Command", "", "", ConfigurationField.Optional.NOT_OPTIONAL));
		return configurationRequest;
	}

	@Override
	public void initialize(Configuration arg0)
			throws AlarmCallbackConfigurationException {
		configs = new Configuration(arg0.getSource());
	}
	
}
