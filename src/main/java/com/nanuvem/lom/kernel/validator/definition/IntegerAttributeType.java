package com.nanuvem.lom.kernel.validator.definition;

import java.util.ArrayList;
import java.util.List;

import com.nanuvem.lom.api.Attribute;
import com.nanuvem.lom.kernel.validator.MaximumValueAttributeConfigurationValidator;
import com.nanuvem.lom.kernel.validator.MinimumValueAttributeConfigurationValidator;
import com.nanuvem.lom.kernel.validator.configuration.AttributeTypeValidator;
import com.nanuvem.lom.kernel.validator.configuration.AttributeValidator;
import com.nanuvem.lom.kernel.validator.configuration.ConfigurationFieldValidator;
import com.nanuvem.lom.kernel.validator.configuration.AttributeValidatorWithValue;
import com.nanuvem.lom.kernel.validator.configuration.MandatoryValidator;
import com.nanuvem.lom.kernel.validator.configuration.MinAndMaxValidator;

public class IntegerAttributeType implements AttributeTypeDefinition {

	public List<AttributeValidator> getValidators() {
		List<AttributeValidator> validators = new ArrayList<AttributeValidator>();

		validators.add(new MandatoryValidator());
		validators.add(new AttributeTypeValidator(Integer.class));
		
		validators.add(new ConfigurationFieldValidator(
				Attribute.DEFAULT_CONFIGURATION_NAME, Integer.class));

		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MINVALUE_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MinimumValueAttributeConfigurationValidator(), Integer.class));
		validators.add(new AttributeValidatorWithValue<Integer>(
				Attribute.MAXVALUE_CONFIGURATION_NAME,
				Attribute.DEFAULT_CONFIGURATION_NAME,
				new MaximumValueAttributeConfigurationValidator(), Integer.class));
		validators.add(new MinAndMaxValidator(
				Attribute.MAXVALUE_CONFIGURATION_NAME,
				Attribute.MINVALUE_CONFIGURATION_NAME));

		validators.add(new ConfigurationFieldValidator(
				Attribute.MANDATORY_CONFIGURATION_NAME, Boolean.class));

		return validators;
	}

	public boolean containsConfigurationField(String fieldName) {
		return Attribute.MANDATORY_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.DEFAULT_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MINVALUE_CONFIGURATION_NAME.equals(fieldName)
				|| Attribute.MAXVALUE_CONFIGURATION_NAME.equals(fieldName);
	}

	public Class<?> getAttributeClass() {
		return Integer.class;
	}

}
