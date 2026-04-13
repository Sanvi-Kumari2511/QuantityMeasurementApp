package com.apps.quantitymeasurement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.dto.QuantityInputDTO;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")	
@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

	@Autowired
	private IQuantityMeasurementService service;

	// ================= COMPARE =================

	@PostMapping("/operations/compare")
	public boolean compare(@Valid @RequestBody QuantityInputDTO input) {

		return service.compare(
				input.getThisQuantityDTO(),
				input.getThatQuantityDTO()
		);
	}

	// ================= CONVERT =================

	@PostMapping("/operations/convert/{targetUnit}")
	public QuantityDTO convert(
			@Valid @RequestBody QuantityDTO input,
			@PathVariable String targetUnit) {

		return service.convert(input, targetUnit);
	}

	// ================= ADD =================

	@PostMapping("/operations/add")
	public QuantityDTO add(@Valid @RequestBody QuantityInputDTO input) {

		return service.add(
				input.getThisQuantityDTO(),
				input.getThatQuantityDTO()
		);
	}

	// ================= SUBTRACT =================

	@PostMapping("/operations/subtract")
	public QuantityDTO subtract(@Valid @RequestBody QuantityInputDTO input) {

		return service.subtract(
				input.getThisQuantityDTO(),
				input.getThatQuantityDTO()
		);
	}

	// ================= DIVIDE =================

	@PostMapping("/operations/divide")
	public double divide(@Valid @RequestBody QuantityInputDTO input) {

		return service.divide(
				input.getThisQuantityDTO(),
				input.getThatQuantityDTO()
		);
	}
}