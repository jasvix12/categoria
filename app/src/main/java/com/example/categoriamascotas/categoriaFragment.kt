package com.example.categoriamascotas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment

class categoriaFragment : Fragment() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListAdapter: ExpandableListAdapter
    private lateinit var listDataHeader: List<String>
    private lateinit var listDataChild: HashMap<String, List<String>>
    private lateinit var listDataHeaderImages: List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categoria, container, false)
        expandableListView = view.findViewById(R.id.expandableListView)

        // Datos
        prepareListData()

        expandableListAdapter = ExpandableListAdapter(requireContext(), listDataHeader, listDataChild, listDataHeaderImages)
        expandableListView.setAdapter(expandableListAdapter)

        return view
    }

    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = HashMap()
        listDataHeaderImages = ArrayList()

        // Agregar encabezados de lista
        (listDataHeader as ArrayList<String>).add("Gatos")
        (listDataHeader as ArrayList<String>).add("Peces")
        (listDataHeader as ArrayList<String>).add("Perros")
        (listDataHeader as ArrayList<String>).add("Conejos")
        (listDataHeader as ArrayList<String>).add("Pollos")

        // Agregar imágenes de encabezados de lista (ejemplo de imágenes de drawable)
        (listDataHeaderImages as ArrayList<Int>).add(R.drawable.gato)
        (listDataHeaderImages as ArrayList<Int>).add(R.drawable.peces)
        (listDataHeaderImages as ArrayList<Int>).add(R.drawable.perro)
        (listDataHeaderImages as ArrayList<Int>).add(R.drawable.conejos)
        (listDataHeaderImages as ArrayList<Int>).add(R.drawable.pollos)

        // Agregar elementos de lista
        val gatos = ArrayList<String>()
        gatos.add("Comida")
        gatos.add("Juguetes")
        gatos.add("Medicamentos")
        gatos.add("Accesorios")

        val peces = ArrayList<String>()
        peces.add("Comida")
        peces.add("Acuarios")
        peces.add("Accesorios")

        val perros = ArrayList<String>()
        perros.add("Comida")
        perros.add("Juguetes")
        perros.add("Ropa")
        perros.add("Accesorios")

        val conejos = ArrayList<String>()
        conejos.add("Comida")
        conejos.add("Juguetes")
        conejos.add("Jaulas")
        conejos.add("Accesorios")

        val pollos = ArrayList<String>()
        pollos.add("Comida")
        pollos.add("Gallineros")
        pollos.add("Accesorios")

        listDataChild[listDataHeader[0]] = gatos
        listDataChild[listDataHeader[1]] = peces
        listDataChild[listDataHeader[2]] = perros
        listDataChild[listDataHeader[3]] = conejos
        listDataChild[listDataHeader[4]] = pollos
    }
}

