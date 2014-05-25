<?php

interface PackageDistributionResolver {
	/**
	 * Retourne le nombre et le type de paquets pour le volume specifie
	 * @param float $volume le volume a conditionner
	 * @return array nombre et type de paquet   
	 */
	public function resolve($volume);
}