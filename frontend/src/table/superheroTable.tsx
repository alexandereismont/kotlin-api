import React, {useEffect, useState} from 'react';
import {DataGrid, GridColDef, GridDensityTypes} from '@mui/x-data-grid';
import {useKeycloak} from "@react-keycloak/web";

const columns: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70, flex: 1 },
    { field: 'name', headerName: 'Name', width: 130, flex: 1 },
    {
        field: 'rating',
        headerName: 'Rating',
        type: 'number',
        width: 90,
        flex: 1,
    },
    {
        field: 'company',
        headerName: 'Company',
  //      description: 'This column has a value getter and is not sortable.',
   //     sortable: false,
        width: 160,
        flex: 1,
    },
    {
        field: "createdAt",
        headerName: "Created at",
        flex: 1,
    },
    {
        field: "updatedAt",
        headerName: "Updated at",
        flex: 1,
    }
];

const rows = [
    {id:1, name: "Batman", rating: 2, company: 'DC', createdAt: "2022-01-01", updatedAt: "2022-02-01"},
];

export const SuperheroTable = () => {
    const [data, setDate] = useState([])

    const { keycloak, initialized } = useKeycloak();

    useEffect(() => {
        const fetchData = async () => {
            const superheroes = await fetch("http://localhost:8083/api/superheroes", {
                headers: {
                    "Authorization": 'Bearer ' + keycloak.token,
                    'Access-Control-Allow-Origin': '*'
                }
            })
            setDate(await superheroes.json())
          //  console.log(await superheroes.json())
        }
        fetchData()
    })

    return (
        <div>
            <DataGrid
                density={GridDensityTypes.Standard}
                autoHeight
                pageSize={5}
                rowsPerPageOptions={[5]}
                columns={columns}
                rows={data}
                checkboxSelection
                showColumnRightBorder={false}
            />
        </div>
    )
}
