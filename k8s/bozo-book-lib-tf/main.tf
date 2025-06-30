data ibm_resource_group "resource_group" {
  name = "Default"
}

resource ibm_container_cluster "kvijay-tf-cluster" {
    name            = "kvijay-tf-cluster"
    datacenter      = "dal10"
    machine_type    = "b3c.4x16"
    hardware        = "shared"
    public_vlan_id  = "2895826"
    private_vlan_id = "2895828"

    kube_version = "1.20"

    default_pool_size = 3

    public_service_endpoint  = "true"
    private_service_endpoint = "true"

    resource_group_id = data.ibm_resource_group.resource_group.id
}



