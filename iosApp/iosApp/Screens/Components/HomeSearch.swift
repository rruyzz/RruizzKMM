import SwiftUI
import shared


struct HomeSearch: View {
    var carousselMovie: [Movie]
    
    @State private var currentIndex = 0
    
    var body: some View {
        ScrollView(.horizontal) {
            LazyHStack(spacing: 0) {
                ForEach(0..<carousselMovie.count, id: \.self) { index in
                    CarousselImage(carousselImage: carousselMovie.first?.backdropPath ?? "")
                }
            }
        }
    }
}

struct CarousselImage: View {
    var carousselImage: String
    
    var body: some View {
        AsyncImage(url: URL(string: carousselImage)) { phase in
            if phase.image != nil {
                phase.image!.resizable().aspectRatio(contentMode: .fit)
            } else if phase.error != nil {
                Text("Image Load Error")
            } else {
                ProgressView()
            }
        }
    }
}
