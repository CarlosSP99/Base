package com.utad.base.ui.secondFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.utad.base.R
import com.utad.base.databinding.FragmentMainBinding
import com.utad.base.databinding.FragmentSecondBinding
import com.utad.base.model.Ropa
import com.utad.base.ui.mainFragment.MainFragment
import com.utad.base.ui.mainFragment.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val args: SecondFragmentArgs by navArgs()
    private val viewModel: ViewModelDetail by viewModels()
    private val idItem by lazy { args.idItem }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentSecondBinding.inflate(inflater, container, false)

        initUI(
        )
        return binding.root
    }

    private fun initUI() {
      lifecycleScope.launch {
          viewModel.searchForThisItem(idItem)
      }
        paintUI()
    }

    private fun paintUI() {
        lifecycleScope.launch {
            viewModel.uiState.collect{

                Glide.with(binding.imagen.context)
                    .load(it.objetoAMostrar.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.imagen)
                binding.Precio.text=it.objetoAMostrar.price.toString()+" $"
                binding.title.text=it.objetoAMostrar.title
                binding.Descripcion.text=it.objetoAMostrar.description
            }
        }
    }


}