import React, {useEffect, useState} from 'react';
import {Forms} from "../../forms/Forms";
import {SuperheroTable} from "../../table/superheroTable";
import {useKeycloak} from "@react-keycloak/web";
import any = jasmine.any;

export const DataContainer = () => {
    const [data, setDate] = useState([]);
    const [search, setSearch] = useState('')
    const { keycloak, initialized } = useKeycloak();

    const fetchSuperheros = (search: string) => {
        const fetchData = async () => {
            let url = 'http://localhost:8083/api/superheroes'
            if(search && search !== '')
                url += `/namePattern=${search}`
            console.log(url);
            console.log(keycloak.token)
            const superheroes = await fetch(url, {
                headers: {
                    "Authorization": 'Bearer ' + keycloak.token,
                    'Access-Control-Allow-Origin': '*'
                }
            })
            setDate(await superheroes.json())
        }
        if(keycloak.token) {
            fetchData()
        }
    }

    useEffect(() => {
        console.log("effect")
        console.log(keycloak.authenticated)
        fetchSuperheros('')
    }, [keycloak.authenticated])

    return (
        <>
            <Forms setSearch={setSearch}/>
            <SuperheroTable data={data} search={search} />
        </>
    )
}
