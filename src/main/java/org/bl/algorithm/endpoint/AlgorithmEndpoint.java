package org.bl.algorithm.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.bl.algorithm.ws.GetAlgorithmRequest;
import org.bl.algorithm.ws.GetAlgorithmResponse;

@Endpoint
public class AlgorithmEndpoint {
	private static final String NAMESPACE_URI = "http://algorithm.bl.org/ws";

	private AlgorithmRepository algorithmRepository;

	@Autowired
	public AlgorithmEndpoint(AlgorithmRepository algorithmRepository) {
		this.algorithmRepository = algorithmRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAlgorithmRequest")
	@ResponsePayload
	public GetAlgorithmResponse getCountry(@RequestPayload GetAlgorithmRequest request) {
		GetAlgorithmResponse response = new GetAlgorithmResponse();
		response.setAlgorithm(algorithmRepository.findAlgorithm(request.getName()));

		return response;
	}
}
