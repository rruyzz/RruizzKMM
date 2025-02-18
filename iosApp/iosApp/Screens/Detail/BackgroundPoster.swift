import SwiftUI

struct BackgroundPoster: View {
    var title: String
    var imageName: String
    
    var body: some View {
        VStack {
            AsyncImage(url: URL(string: imageName)) { image in
                if image.image != nil {
                    image.image!
                        .resizable()
                        .scaledToFill()
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                        .overlay(
                            alignment: .bottomTrailing,
                            content: {
                                HStack {
                                    Text(title)
                                        .bold()
                                        .padding(.leading, 8)
                                    Image(systemName: "star")
                                        .font(.title2)
                                        .foregroundColor(.white)
                                        .padding(.trailing, 8)
                                }
                                .background(Color.gray)
                                .cornerRadius(4)
                                .padding(8)
                            }
                        )
                } else if image.error != nil {
                    Text("Image Load Error")
                } else {
//                    ProgressView()
                }
            }
        }
    }
}

//#Preview {
//    BackgroundPoster()
//}
