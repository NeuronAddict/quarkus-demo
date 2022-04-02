import React from 'react'
import {Fruit} from "./fruit";

interface Props {
    fruits: Fruit[];
}

const Fruits = ({ fruits }: Props) => {
    return (
        <div>
            <h1>Particles List</h1>
            <table className="pf-c-table pf-m-grid-md" role="grid" aria-label="Supersonic Subatomic Particles" id="table-basic">
                <caption>Supersonic Subatomic Particles</caption>
                <thead>
                <tr role="row">
                    <th role="columnheader" scope="col">Name</th>
                </tr>
                </thead>
                {fruits.map((fruit: Fruit) => (
                    <tbody role="rowgroup">
                    <tr role="row">
                        <td role="cell" data-label="Particle name">{fruit.name}</td>
                    </tr>
                    </tbody>
                ))}
            </table>
        </div>
    )
};

export default Fruits