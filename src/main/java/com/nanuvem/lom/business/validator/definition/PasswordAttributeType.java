package com.nanuvem.lom.business.validator.definition;

import java.util.ArrayList;
import java.util.List;

import com.nanuvem.lom.api.Attribute;
import com.nanuvem.lom.business.validator.MaximumLengthAttributeConfigurationValidator;
import com.nanuvem.lom.business.validator.MaximumRepeatAttributeConfigurationValidator;
import com.nanuvem.lom.business.validator.MinimumLengthAttributeConfigurationValidator;
import com.nanuvem.lom.business.validator.MinimumNumbersAttributeConfigurationValidator;
import com.nanuvem.lom.business.validator.MinimumSymbolsAttributeConfigurationValidator;
import com.nanuvem.lom.business.validator.MinimumUppersAttributeConfigurationValidator;
import com.nanuvem.lom.business.validator.configuration.AttributeValidator;
import com.nanuvem.lom.business.validator.configuration.AttributeValidatorWithValue;
import com.nanuvem.lom.business.validator.configuration.ConfigurationFieldValidator;
import com.nanuvem.lom.business.validator.configuration.MandatoryValidator;
import com.nanuvem.lom.business.validator.configuration.MinAndMaxValidator;

public class PasswordAttributeType implements AttributeTypeDefinition {

	public List<AttributeValidator> getValidators() {
		List<AttributeValidator> validators = new ArrayList<AttributeValidator>();

		validators.add(new MandatoryValidator());

		validators.add(new ConfigurationFieldValidator(
				Attribute.DEFAULT_CONFIGURATION_NAME, String.class));
		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MINLENGTH_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MinimumLengthAttributeConfigurationValidator(), Integer.class));
		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MAXLENGTH_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MaximumLengthAttributeConfigurationValidator(), Integer.class));
		validators.add(new MinAndMaxValidator(
				Attribute.MAXLENGTH_CONFIGURATION_NAME,
				Attribute.MINLENGTH_CONFIGURATION_NAME));
		
		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MINUPPERS_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MinimumUppersAttributeConfigurationValidator(), Integer.class));

		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MINNUMBERS_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MinimumNumbersAttributeConfigurationValidator(), Integer.class));

		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MINSYMBOLS_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MinimumSymbolsAttributeConfigurationValidator(), Integer.class));

		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MAXREPEAT_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MaximumRepeatAttributeConfigurationValidator(), Integer.class));

		validators.add(new ConfigurationFieldValidator(
				Attribute.MANDATORY_CONFIGURATION_NAME, Boolean.class));

		return validators;
	}

	public boolean containsConfigurationField(String fieldName) {
		return Attribute.MANDATORY_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.DEFAULT_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MINLENGTH_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MAXLENGTH_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MINUPPERS_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MINNUMBERS_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MINSYMBOLS_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MAXREPEAT_CONFIGURATION_NAME.equals(fieldName);
	}

	public Class<?> getAttributeClass() {
		return String.class;
	}
}
