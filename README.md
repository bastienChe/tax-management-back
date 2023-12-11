# so043-ms006-reporting-springboot 

Micro service du domaine so043 chargé d'exposer des services de reporting sur les échanges entre domaines, les CREMs en erreur et les performances du cycle de vie complet du CREM (emission, transit, traitement/rejet).

Route de récupération des domaines en prod : https://so043-suivicrem.apps.tas-prod.pole-emploi.intra/reporting/domaines

Route de récupération des CREMs en erreur pour le domaine récepteur CA003 en prod : https://so043-suivicrem.apps.tas-prod.pole-emploi.intra/reporting/domaines/CA003/crems-en-erreur?limite=100

Routes de récupération des performances : 
- De l'émission (statut depot -> emis) : https://so043-suivicrem.apps.tas-prod.pole-emploi.intra/reporting/performances/emission
- Du transit (statut emis -> reçu) : https://so043-suivicrem.apps.tas-prod.pole-emploi.intra/reporting/performances/transit
- Du traitement (statut reçu -> traité) : https://so043-suivicrem.apps.tas-prod.pole-emploi.intra/reporting/performances/traite
- Du rejet (statut reçu -> rejeté) : https://so043-suivicrem.apps.tas-prod.pole-emploi.intra/reporting/performances/rejete

Seul le premier statut de traitement (traité ou rejeté) est considéré.
Dans le cas d'un CREM rejeté puis traité, le temps de performance relevé sera celui du rejet (le 1er dans l'ordre chronologique)

## Pré-requis

En local, il est nécessaire d'avoir docker et maven installé.

## Build

- Sous linux, lancer la commande

```shell
mvn clean verify -P ti-local
```

(Si, à travers le VPN, les tests ne fonctionnent pas, pour non connexion aux instances docker, lancer
```shell
mvn clean verify -P ti-local -Ddocker.network=host
```
)

- Sous windows, lancer la commande

```shell
mvn clean verify -P ti-local-windows
```

## IC et Deploiement

ms006-reporting est déployé sur la TAS. L'ensemble est piloté par concourse.

Le pipeline est disponible [ici](https://concourse-equipes.pole-emploi.intra/teams/drosd-sdf/pipelines/so043-ms006-reporting)

Le rapport des tests intégrations est disponible [ici](http://x-concourse-m-save-s3.sauvegarde-s3.stockage-ecs1-qvr.sii24.pole-emploi.intra:9020/rapport-de-test/so043-ms006-reporting/ti/index.html)

## Bench

ms006-reporting est intégré dans le scénario de bench avec les autres micro-services.

Le rapport gatling du scénario court est disponible [ici](http://x-concourse-m-save-s3.sauvegarde-s3.stockage-ecs1-qvr.sii24.pole-emploi.intra:9020/rapport-de-test/so043-test-performance/court/index.html)

Le rapport gatling du scénario long est disponible [ici](http://x-concourse-m-save-s3.sauvegarde-s3.stockage-ecs1-qvr.sii24.pole-emploi.intra:9020/rapport-de-test/so043-test-performance/long/index.html)

## Test acceptance

ms006-reporting est intégré dans le scénario des tests acceptance avec les autres micro-services.

Le rapport est disponible [ici](http://x-concourse-m-save-s3.sauvegarde-s3.stockage-ecs1-qvr.sii24.pole-emploi.intra:9020/rapport-de-test/so043-ms006-reporting/ta/index.html)

## Architecture

![](docs/architecture-ms006-reporting.png)
