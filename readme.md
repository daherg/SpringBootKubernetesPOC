# Spring Features

## Overview
This proof of concept includes 3 micro services. This document should help to get an overview how to run the 
micro services in Kubernetes. 

Each of it represents an Java Spring feature. This document should help 
you to get an overview and a guide.

The repository contains the following micro services.

* Service Addressbook
* Service People
* Service Client

## Preparation
Please install the following programs on your local machine:
* The newest version of git ([https://git-scm.com](https://git-scm.com))
* The newest version of maven ([https://maven.apache.org](https://maven.apache.org))

## Start
* Service Addressbook: navigate into service-addressbook project and run the following command: kubectl create -f service-addressbook-kubernetes-deployment.yml
* Service people: navigate into service-people project and run the following command: kubectl create -f service-people-kubernetes-deployment.yml
